import plagon from '../assets/plagon.png';
import Navigation from './navigation/Navigation';
import './Header.css';

export default function Header() {
    return (
        <div id='header-container'>
            <div id='banner'>
                <h1>D<span>n</span>D-Planner</h1>
                <img src={plagon} alt="A dragon making plans" />
            </div>
            <Navigation/>
        </div>
    );
}