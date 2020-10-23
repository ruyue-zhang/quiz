import React, { Component } from 'react';
import Good from './Good';
import '../style/Goods.css'

class Goods extends Component {
  state = {
    goods: [],
    orderGoods: [],
    carStatus: 'none'
  };
 
  getGoods = async () => {
    fetch("http://localhost:8080/goods").then(response => {
      if(response.status === 200) {
        return response.json()
      } else {
        Promise.reject('get goods error!')
      }
    }).then(data => {
      console.log(data)
      this.setState({
        goods: data
      });
    }).catch(err => {
      console.log(err)
    });
  }
    
  changeCarStatus() {
    // if(this.state.carStatus === 'none') {
    //   this.setState({
    //     carStatus: 'block'
    //   })
    // }
    // if(this.state.carStatus === 'block') {
    //   this.setState({
    //     carStatus: 'none'
    //   })
    // }
  }

  componentDidMount() {
    this.getGoods();
  }

  render() {
    const { goods } = this.state;
    return (
      <div class="container" id="container">
        {goods.map(good => (
          <Good key={good.id} good={good} />
        ))}
        <button onclick={this.changeCarStatus()}>购物车</button>
        <div style={{display: this.state.carStatus}}> 
          <table className="orderList">
            <thead>
              <tr>
                <td>商品</td>
                <td>数量</td>
              </tr>
            </thead>
            <tbody>
              {this.state.orderGoods.map(good => (
                <tr>
                  <td>{good.name}</td>
                  <td>{good.count}</td>
                  <td><button>删除</button></td>
                </tr>
              ))}
            </tbody>
          </table>
          <button type="button" className="btn btn-secondary" data-dismiss="modal">清空</button>
          <button type="button" className="btn btn-primary">立即下单</button>
        </div>
      </div>
    );
  }
}

export default Goods;