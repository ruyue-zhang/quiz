import React, { Component } from 'react';
import '../style/Good.css';
import apple from '../apple.jpg';

class Good extends Component {
  state = {
    name: "苹果",
    price: 2,
    unitOfMeasurement: "斤",
    img: apple,
  }
  render() {
    // const { name, price, unit, img, onAdd } = this.props;
    return (
      <div class="row row-cols-1 row-cols-md-3">
        <div class="col mb-4">
          <div class="card">
            <img src={this.state.img} class="card-img-top" alt="goods_img"/>
            <div class="card-body">
              <h5 class="card-title">{this.state.name}</h5>
              <p class="card-text">单价：{this.state.price}元/{this.state.unitOfMeasurement}</p>
            </div>
            <button>十</button>
          </div>
        </div>
      </div>
      // <div className="goods">
      //   <img >
      //   <div className="buy">
      //     <span className="name">{this.state.name}</span>
      //     <span className="price">单价：{this.state.price}元/{this.state.unitOfMeasurement}</span>
      //   </div>
      //   <button>+</button>
      // </div>
    );
  }
}

export default Good;