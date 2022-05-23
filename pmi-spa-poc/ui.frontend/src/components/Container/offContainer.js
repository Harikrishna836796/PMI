import {
    MapTo,
    withComponentMappingContext,
    AllowedComponentsContainer
} from '@adobe/aem-react-editable-components';

console.log('???', this);

const ContainerConfig = {
    emptyLabel: 'Container',

    isEmpty: function(props) {
        console.log('???2', props);
        return !props || !props.cqItemsOrder || props.cqItemsOrder.length === 0;
    }
};


MapTo('pmi-spa-poc/components/container')(withComponentMappingContext(AllowedComponentsContainer), ContainerConfig);

/*
import React, { Component } from 'react';

class Container extends Component {
  render() {
    console.log('C THIS', this);
    return <div>container</div>;
    ;
  }
}

export default Container;

/*

let element =
  React.createElement(
    // The first argument is the element's `type`
    'a',

    // The second argument is the element's `props`
    { href: 'https://xkcd.com/222/' },

    // Any further arguments, if given, are merged into to
    // `props` under the name `children`.
    React.createElement(
      'img',
      {
        src: "https://imgs.xkcd.com/comics/random_number.png",
        alt: "RFC 1149.5 specifies 4 as the standard IEEE-vetted random number.",
      }
    ),
    React.createElement(
      'span',
      null,
      'By Randall Munroe',
    )
  )

ReactDOM.render(
  element,
  document.getElementById('root')
)
*/
