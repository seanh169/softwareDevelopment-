import React from 'react';
import Input from '../UI/Input/Input';


class FormPrac extends React.Component {
	state = {

		editForm: {
			id: {
				elementType: 'select',
				elementConfig: {
					options: [
						{value: '1', displayValue: '1'},
						{ value: '2', displayValue: '2' }
					]
				},
				value: ''
			},
			first_name: {

				elementType: 'input',
				elementConfig: {
					type: 'text',
					placeholder: 'First Name'
				},
				value: ''
			},
			last_name: {

				elementType: 'input',
				elementConfig: {
					type: 'text',
					placeholder: 'Last Name'
				},
				value: ''
			},
			f_language: {

				elementType: 'input',
				elementConfig: {
					type: 'text',
					placeholder: 'Favorite Langugage'
				},
				value: ''
			}
		},
		
	}

	inputChangedHandler =(event, inputIdentifier) => {
		const updatedEditForm = {
			...this.state.editForm
		};
		const updatedEditFormEl = {
			...updatedEditForm[inputIdentifier]
		};
		updatedEditForm.value = event.target.value;
		updatedEditForm[inputIdentifier] = updatedEditFormEl;
		this.setState({
			editForm: updatedEditForm
		})
	}

	render(){
		const formElementsArray = [];
		for(let key in this.state.editForm) {
			formElementsArray.push({
				id: key,
				config: this.state.editForm[key]
			})
		}
		let form = (
			<form>
			
				{formElementsArray.map(formElement => (
					<Input 
						key={formElement.id}
						elementType={formElement.config.elementType} 
						elementConfig={formElement.config.elementConfig} 
						value={formElement.config.value} 
						changed={(event) => this.inputChangedHandler(event, formElement.id)}

					/>
				))}

			</form>
		);



		return (
			<div>
				{form}
			</div>
		);
	}



}


export default FormPrac;