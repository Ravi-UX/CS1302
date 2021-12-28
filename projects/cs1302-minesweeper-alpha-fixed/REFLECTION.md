I fixed an error where a grid of any size is created. Now the grid is only created when the rows and column values are at least 5.
I also attempted to fix an error which was caused when a command was typed in with an extra token at the end but I was not able to
find a way to check if the player typed extra tokens. I tried to use the hasNext() method of the Scanner class but it does not work for
System.in. Unfortunately I do not know the exact reason why I falied win case 1 but I am pretty sure the reason is because of this bug which I was
 unable to fix.