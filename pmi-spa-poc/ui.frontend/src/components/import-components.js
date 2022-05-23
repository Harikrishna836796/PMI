/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import withAsyncImport from "../utils/withAsyncImport";

import './Page/Page';
import './ExperienceFragment/ExperienceFragment';

import {MapTo} from '@adobe/aem-react-editable-components';

import {
    CarouselV1IsEmptyFn
} from '@adobe/aem-core-components-react-spa/dist/isEmptyFunctions';

import {
    TitleV2IsEmptyFn
} from '@adobe/aem-core-components-react-base/dist/isEmptyFunctions';

import {
    TabsV1, TabsV1IsEmptyFn,
    AccordionV1,AccordionV1IsEmptyFn,
} from '@adobe/aem-core-components-react-spa';

import ContainerV1 from './Container/v1/ContainerV1';
import { ContainerV1IsEmptyFn } from './Container/v1/ContainerV1IsEmptyFn';

import {
    BreadCrumbV2,BreadCrumbV2IsEmptyFn,
    ImageV2,ImageV2IsEmptyFn,
    LanguageNavigationV1,
    NavigationV1,
    TeaserV1,TeaserV1IsEmptyFn,
    DownloadV1,DownloadV1IsEmptyFn,
    ListV2,ListV2IsEmptyFn
} from '@adobe/aem-core-components-react-base';

//lazyload / code splitting example of an internal component
const LazyTextComponent = withAsyncImport(() => import(`./Text/Text`));
const LazyButtonComponent = withAsyncImport(() => import(`./Button/Button`));
const LazySeparatorComponent = withAsyncImport(() => import(`./Separator/Separator`));


//lazyload / code splitting examples of external components
const TitleV2 = withAsyncImport(() => import(`@adobe/aem-core-components-react-base/dist/authoring/title/v2/TitleV2`));
const CarouselV1 = withAsyncImport(() => import(`@adobe/aem-core-components-react-spa/dist/container/carousel/v1/CarouselV1`));


MapTo('pmi-spa-poc/components/download')(DownloadV1, {isEmpty: DownloadV1IsEmptyFn});
MapTo('pmi-spa-poc/components/list')(ListV2, {isEmpty: ListV2IsEmptyFn});
MapTo('pmi-spa-poc/components/teaser')(TeaserV1, {isEmpty: TeaserV1IsEmptyFn});
MapTo('pmi-spa-poc/components/image')(ImageV2, {isEmpty: ImageV2IsEmptyFn});
MapTo('pmi-spa-poc/components/title')(TitleV2, {isEmpty: TitleV2IsEmptyFn});
MapTo('pmi-spa-poc/components/breadcrumb')(BreadCrumbV2, {isEmpty: BreadCrumbV2IsEmptyFn});
MapTo('pmi-spa-poc/components/navigation')(NavigationV1);
MapTo('pmi-spa-poc/components/languagenavigation')(LanguageNavigationV1);
MapTo('pmi-spa-poc/components/tabs')(TabsV1, {isEmpty: TabsV1IsEmptyFn});
MapTo('pmi-spa-poc/components/accordion')(AccordionV1, {isEmpty: AccordionV1IsEmptyFn});
MapTo('pmi-spa-poc/components/carousel')(CarouselV1, {isEmpty: CarouselV1IsEmptyFn});
MapTo('pmi-spa-poc/components/container')(ContainerV1, {isEmpty: ContainerV1IsEmptyFn});

//lazy load of internal component (hello world)

/**
 * Default Edit configuration for the Text component that interact with the Core Text component and sub-types
 *
 * @type EditConfig
 */
const TextEditConfig = {
    emptyLabel: 'Text',

    isEmpty: function (props) {
        return !props || !props.text || props.text.trim().length < 1;
    }
};

MapTo('pmi-spa-poc/components/text')(LazyTextComponent, TextEditConfig);
MapTo('pmi-spa-poc/components/button')(LazyButtonComponent);
MapTo('pmi-spa-poc/components/separator')(LazySeparatorComponent);
