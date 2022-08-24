import { mount } from 'products/ProductsIndex';
import { mount as mountCart } from 'cart/CartShow';
import 'cart/CartShow';

console.log('Container!');

mount(document.querySelector('#dev-products'));

mountCart(document.querySelector('#cart-container'));