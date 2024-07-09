function Challenge({ challenge }) {
  return (
      <div>
          <h5>{challenge.challengeMonth}</h5>
          <p>{challenge.description}</p>
      </div>
  );
}

export default Challenge;
