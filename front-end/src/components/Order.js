import React, { Component } from 'react';
import '../style/Order.css'

class Order extends Component {
  state = {
    orderGoods: [
      {
          "id": 1,
          "name": "可乐",
          "price": 2,
          "unitOfMeasurement": "瓶",
          "count": 1
      },
      {
          "id": 2,
          "name": "泡面",
          "price": 2,
          "unitOfMeasurement": "包",
          "count": 1
      },
      {
          "id": 3,
          "name": "薯片",
          "price": 7,
          "unitOfMeasurement": "袋",
          "count": 1
      },
      {
          "id": 4,
          "name": "香蕉",
          "price": 3,
          "unitOfMeasurement": "斤",
          "count": 1
      }
    ]
  }
  render() {
    // const { orderGoods } = this.props.orderGoods;
    return (
      <div class="container">
        <table className="orderList">
          <thead>
            <tr>
              <td>名字</td>
              <td>单价</td>
              <td>数量</td>
              <td>单位</td>
              <td>操作</td>
            </tr>
          </thead>
          <tbody>
            {this.state.orderGoods.map(good => (
              <tr>
                <td>{good.name}</td>
                <td>{good.price}</td>
                <td>{good.unitOfMeasurement}</td>
                <td>{good.count}</td>
                <td><button>删除</button></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Order;