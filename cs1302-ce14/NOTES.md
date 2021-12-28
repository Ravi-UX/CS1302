I think the exercise demonstrates the uses of generic methods.
The non generic version is more error prone because it allows val to be added to the array even if the the type of the array is not a super type.
The generic methods prevent improper arguments from being passed when being invoked