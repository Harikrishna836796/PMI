import React, { Component } from 'react';

require('./Separator.css');

class Separator extends Component {
  render() {
    return <div className="separator" style={{height: this.props.size + "px"}} ></div>;
  }
}

export default Separator;
