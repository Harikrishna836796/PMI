# POC-1 - Container for 12 column grid
[URL to container javascript component](pmi-spa-poc/ui.frontend/src/components/Container/v1)

This approach provides a posibility to drag and drop container size and alignment into 12 column grid system and let you define different size or visibility for different kind of screen sizes.

### Container configuration:
  - background image
  - background color (color hex code from colorpicker)
  - padding left
  - padding right

### Additional styles:
  - border
  - inline left (all 3 inline styles are converting child block elements to inline elements so they can be horizontally aligned)
  - inline right
  - inline center



# POC-2 - Container as a flexbox.
[URL to container javascript component](pmi-spa-poc/ui.frontend/src/components/Container/v2)

This approach let as display and style containers like CSS flexbox elements.

### Flex-container additional configuration provides:
  - background image
  - background color (color hex code from colorpicker)
  - padding left
  - padding right
  - flex-direction
  - flex-wrap
  - flexbox justify-content
  - flexbox align-content
  - flexbox align-items
  - flex-grow (responsible for container width)
  - flex-shrink


# Globally

As a base of custom container code and implementation we used this repo:
https://github.com/adobe/aem-react-core-wcm-components-spa

### CSS

CSS for both POCs layouting are kept in a single place to get a better overview:
[pmi-spa-poc/ui.frontend/src/components/Page/Page.css](pmi-spa-poc/ui.frontend/src/components/Page/Page.css)

For container paddings we have 3 options (*small, medium, large*) which will add css classes, for example for padding-left: (padding-left-sm, padding-left-md, padding-left-lg) so we have posibility to adjust size of padding for different screen sizes.

### Components

Created 2 additional custom react components for **button** and **separator**.

  - **Separator**
    - Can be configurated via dialog box, there is one option for its size in pixels. This can be used to create additional vertical spacings. (Horizontal spacings are supposed to create by container padding-left and padding-right)

  - **Button**
    - all standart button/link atributes.
    - style variations which is addign coresponding css class name to button element.
    - posibility to add margins to all 4 sides: margin-top, margin-bottom, margin-left, margin-right
