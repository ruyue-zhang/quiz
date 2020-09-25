import React from 'react';
import { NavLink } from 'react-router-dom';
import './Header.css'

const Header = () => {
  return (
    <div className="header">
      <NavLink exact to="/" activeClassName="nav_active" className="nav_item">商城</NavLink>
      <NavLink exact to="/order" activeClassName="nav_active" className="nav_item">订单</NavLink>
      <NavLink exact to="/add" activeClassName="nav_active" className="nav_item">添加商品</NavLink>
    </div>
  );
}

export default Header;
