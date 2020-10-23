import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Header from './components/Header';
import Add from './components/Add';
import Goods from './components/Goods';
import Order from './components/Order';

class App extends Component {
  render() {
    return (
      <div className="app">
        <Router>
        <Header />
          <Switch>
            <Route exact path='/add' component={Add} />
            <Route exact path='/order' component={Order} />
            <Route exact path='/' component={Goods} />
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
