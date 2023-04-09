
# YourMoney Budget Tracker Android App
//Build using Jetpack Compose and Material Design 3




## How to Revert Back to the previous version?

Jumping back to the previous version of my code after coding and fixing bugs for the last 2 days, because I am getting a lot of unexpectional error.
And this problem taught me how to revert back to the previous version of my repo.

```bash
  > git log

  // This will show all the commits till date you have done, all the commit will be shown with their ids and date.
  // remember to copy the id of the particular commit date you want to revert back your code to.

  > git reset --hard "put your commit id here within the brackets"


  // If you are using powershell or terminal opened directly from your project folder then type this:
  > git push -f github master

  // If you are using and IDE then write this:
  > git push -f origin master or main (whichever is your branch is. You can check that in the end of your settings section of your repository)
```

