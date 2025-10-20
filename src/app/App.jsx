import { useState } from 'react';
import { 
  GoogleOAuthProvider,
  GoogleLogin
} from '@react-oauth/google';
import { jwtDecode } from 'jwt-decode';
import Header from '../header/Header';
import FrontPage from '../frontPage/FrontPage';

function App() {
    const [ profile, setProfile ] = useState([]);

    return (
      <GoogleOAuthProvider clientId="147027263228-coavpmhg18ifsb5ahnuvska434r5qofh.apps.googleusercontent.com">
        <Header/>
          {profile ? (
            <FrontPage profile={profile} setProfile={setProfile} />
          ) : (
              <GoogleLogin onSuccess={credentialResponse => {
                const token = credentialResponse.credential;
                const decoded = jwtDecode(token);
                setProfile(decoded);
              }} onError={() => {
                console.error('Login Failed');
              }}
              />
          )}
    </GoogleOAuthProvider>
    )
}

export default App;
