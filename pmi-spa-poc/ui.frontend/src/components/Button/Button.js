import React, { Component } from 'react';

require('./Button.css');

/**
 * Button React component
 */
class Button extends Component {
  render() {
    return <a
              id={ this.props.id }
              href={ this.props.link }
              className={ `btn ${this.props.styleVariation} ${this.props.marginBottom} ${this.props.marginEnd} ${this.props.marginStart} ${this.props.marginTop}` }
              title={ this.props.accessibilityLabel }>
                { this.props.text }
            </a>;
  }
}

export default Button;
