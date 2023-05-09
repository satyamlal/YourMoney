
# YourMoney Budget Tracker Android App
//Build using Jetpack Compose and Material Design 3

This is an Expense Tracker app build using only Jetpack Compose and Material3 Icons.


## Acknowledgements

- [Color Picker](https://github.com/skydoves/colorpicker-compose)

- [Swipe Feature](https://github.com/saket/swipe)

- [Kotlin Faker](https://github.com/serpro69/kotlin-faker)

- [Charts](https://github.com/tehras/charts)



## Badges

[Realm db](https://webimages.mongodb.com/_com_assets/cms/ku4ddeuf4tkw2nhdr-realm_social_share.png)](https://www.mongodb.com/docs/realm/sdk/kotlin/install/#std-label-kotlin-install-android)

[Sentry](https://vectorlogoseek.com/wp-content/uploads/2020/02/sentry-io-vector-logo.png)](https://opensource.org/licenses/)


## Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Surface | ![#000000](https://placehold.co/15x15/000000/000000.png) `#000000` |
| Destructive | ![#ff453a](https://placehold.co/15x15/ff453a/ff453a.png) `#FF453A` |
| TextPrimary | ![#ffffff](https://placehold.co/15x15/ffffff/ffffff.png) `#FFFFFF` |
| Primary | ![#0A84FF](https://placehold.co/15x15/0A84FF/0A84FF.png) `#0A84FF` |
| SystemGray | ![#3A3A3C](https://placehold.co/15x15/3A3A3C/3A3A3C.png) `#3A3A3C` |
| BackgroundElevated | ![#28282B](https://placehold.co/15x15/28282B/28282B.png) `#28282B` |
| LabelSecondary | ![#8E8E93](https://placehold.co/15x15/8E8E93/8E8E93.png) `#8E8E93` |
| DividerColor | ![#787880](https://placehold.co/15x15/787880/787880.png) `#787880` |
| TopAppBarBackground | ![#28282B](https://placehold.co/15x15/28282B/28282B.png) `#28282B` |
| FillTertiary | ![#28282B](https://placehold.co/15x15/28282B/28282B.png) `#28282B` |



## Features

- Dark Mode
- All the history dates can be accessed and edited
- Fullscreen mode
- Categories can be customized with various colors
- All the expenses will be displayed with charts for ease
- Chart is swipeable to left and right in Reports screen
- Expenses is filtered using a dropdown menu




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

