import { useState } from "react";
import axios from "axios";

function AddChallenge({ onChallengeAdded }) {
    const [challengeMonth, setChallengeMonth] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/challenges', { challengeMonth, description });
            setChallengeMonth('');
            setDescription('');
            onChallengeAdded();
        } catch (error) {
            console.error("Error posting data:", error);
        }
    };

    return (
        <div className="card my-5">
            <div className="card-header">
                Add new challenge
            </div>
            <div className="card-body">
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="challengeMonth">Month</label>
                    <input type="text" id="challengeMonth" value={challengeMonth} onChange={(e) => setChallengeMonth(e.target.value)} required />
                </div>
                <div>
                    <label htmlFor="description">Description</label>
                    <textarea id="description" value={description} onChange={(e) => setDescription(e.target.value)} required />
                </div>
                <button type="submit">Submit</button>
            </form>
            </div>
        </div>
    );
}

export default AddChallenge;
