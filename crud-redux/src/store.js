import {createContext} from 'react';

const initialState = {
    list: {
        elements: []
    },
    todo: {
        elements: [],
        item: {}
    },
    mensage: {}
};

const Store = createContext(initialState);

export default Store;