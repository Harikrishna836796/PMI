import React, { Component } from 'react';

require('./Button.css');

/**
 * Button React component
 */
class Button extends Component {
  render() {
    console.log('BTN PROPS', this.props);
    return <a
              id={ this.props.id }
              href={ this.props.link }
              className={ `btn ${this.props.styleVariation}` }
              title={ this.props.accessibilityLabel }>
                { this.props.text }
            </a>;
  }
}

export default Button;
