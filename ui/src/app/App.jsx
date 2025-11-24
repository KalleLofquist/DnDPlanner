import { useState } from 'react';
import {
  GoogleOAuthProvider,
  GoogleLogin
} from '@react-oauth/google';
import { jwtDecode } from 'jwt-decode';
import Header from '../header/Header';
import FrontPage from '../frontPage/FrontPage';

function App() {

  const [profile, setProfile] = useState(() => {
    const savedProfile = localStorage.getItem('userProfile');
    return savedProfile ? JSON.parse(savedProfile) : null;
  });

  const onLoginSuccess = (credentialResponse) => {
    const token = credentialResponse.credential;
    const decoded = jwtDecode(token);
    setProfile(decoded);
    localStorage.setItem('userProfile', JSON.stringify(decoded));
    localStorage.setItem('authToken', token);
  }

  const onLoginError = () => {
    console.error('Login Failed');
  }

  return (
    <GoogleOAuthProvider clientId="147027263228-coavpmhg18ifsb5ahnuvska434r5qofh.apps.googleusercontent.com">
      <Header />
      {profile ? (
        <FrontPage profile={profile} setProfile={setProfile} />
      ) : (
        <div style={{ colorScheme: "light", display: 'flex', justifyContent: 'center', marginTop: '20px' }}>
          <GoogleLogin
            onSuccess={credentialResponse => onLoginSuccess(credentialResponse)}
            onError={() => onLoginError()}
            theme='filled_black'
            text='signin'
            shape='pill' />
        </div>
      )}
    </GoogleOAuthProvider>
  )
}

export default App;
