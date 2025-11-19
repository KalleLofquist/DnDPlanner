import { googleLogout } from '@react-oauth/google';

export default function FrontPage({ profile, setProfile }) {

    // log out function to log the user out of google and set the profile array to null
    const logOut = () => {
        googleLogout();
        setProfile(null);
    };

    return (
        <div>
            <h2>Welcome to the Front Page {profile.name}!</h2>
            <img src={profile.picture} alt="user image" />
            <p>This is the main landing page of the application.</p>
            <button onClick={logOut}>Log out</button>
        </div>
    );
}