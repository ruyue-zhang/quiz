import React, { Component } from 'react';
import '../style/Add.css';
import 'bootstrap/dist/css/bootstrap.css'

class Add extends Component {
  state = {
    name: "",
    price: "",
    unit: "",
    img: "",
  }

  handleInputChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    });
  };

  hadleForSubmit = (event) => {
    event.preventDefault();
    console.log(
      "name:", this.state.name, 
      "gender:", this.state.gender, 
      "description:", this.state.description,
      "checked:", this.state.checked
    );
  }

  render() {
    return (
      <div className="container">
        <h5>添加商品</h5>
        <form action="">
          <div className="form-group">
            <label htmlFor="exampleFormControlInput1"> *名称：</label>
            <input type="text" 
                   className="form-control" 
                   id="exampleFormControlInput1" 
                   placeholder="名称" 
                   value={this.state.name}
                   onChange={(event) => this.handleInputChange("name", event)}
            />
          </div>
          <div className="form-group">
            <label htmlFor="exampleFormControlInput1">*价格：</label>
            <input type="text" 
                   className="form-control" 
                   id="exampleFormControlInput1" 
                   placeholder="价格" 
                   value={this.state.price}
                   onChange={(event) => this.handleInputChange("price", event)}
            />
          </div>
          <div className="form-group">
            <label htmlFor="exampleFormControlInput1">*单位：</label>
            <input type="text" 
                   className="form-control" 
                   id="exampleFormControlInput1" 
                   placeholder="单位" 
                   value={this.state.unit}
                   onChange={(event) => this.handleInputChange("unit", event)}
            />
          </div>
          <div className="form-group">
            <label htmlFor="exampleFormControlInput1">*图片</label>
            <input type="text" 
                   className="form-control" 
                   id="exampleFormControlInput1" 
                   placeholder="图片" 
                   value={this.state.img}
                   onChange={(event) => this.handleInputChange("img", event)}
            />
          </div>
          <input type="submit" value="Submit" className="btn btn-primary" 
            disabled={!this.state.name || !this.state.price || !this.state.unit || !this.state.img}/>
        </form>
      </div>
    );
  }
}

export default Add;