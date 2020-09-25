import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Header from './components/header/Header';

class App extends Component {
  render() {
    return (
      <div className="app">
        <Router>
          <Header />
          <Switch>
            {/* <Route exact path='/add' component={Header} /> */}
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
