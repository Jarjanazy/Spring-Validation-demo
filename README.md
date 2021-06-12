## **What Do We Want To Do?** 🤔
Apply validation to the objects we receive at the endpoint controllers from clients.

## **What Is The First Solution That Comes To Mind?** 🧠
it's simple, right? write functions that validate those objects.

## Please meet the Javax validator.🥳
- It provides a set of annotations that are used with class fields.
- They act as constraints.
	- this field should not be null
	- this list should have a minimum size of 5
	- and many more...

## How to do it?👀

For the object we want to validate
- We annotate the fields we want to validate with annotations from ```javax.validation.constraints```

- Then, we annotate the parameter of the controller where we want to validate.

- We then have to catch the error thrown by the validator, and return a proper response to the user.


## In conclusion✍️
- Imagine having an API with many endpoints that we need to validate. Which method would be better?
- The Validator.
