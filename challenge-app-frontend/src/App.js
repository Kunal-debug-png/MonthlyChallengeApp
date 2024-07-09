import './App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';
import ChallengeList from './ChallengeList';
import AddChallenge from './AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
    const [challenges, setChallenges] = useState([]);

    const fetchChallenges = async () => {
        try {
            const response = await axios.get('http://localhost:8080/challenges');
            setChallenges(response.data);
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    };

    useEffect(() => {
        fetchChallenges();
    }, []);

    const handleChallengeAdded = () => {
        fetchChallenges();
    };

    return (
        <div className="container mt-5">
            <h1 className='text center mb-4'>Monthly Challenges</h1>
            <AddChallenge onChallengeAdded={handleChallengeAdded} />
            <ChallengeList challenges={challenges} />
        </div>
    );
}

export default App;
