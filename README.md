
# YourMoney Budget Tracker Android App
//Build using Jetpack Compose and Material Design 3

This is an Expense Tracker app build using only Jetpack Compose and Material3 Icons.


## Acknowledgements

- [Color Picker](https://github.com/skydoves/colorpicker-compose)

- [Swipe Feature](https://github.com/saket/swipe)

- [Kotlin Faker](https://github.com/serpro69/kotlin-faker)

- [Charts](https://github.com/tehras/charts)



## Badges

![RealmDB](https://img.shields.io/badge/realmdb-Realm%20DB-%2359569E)

![Sentry.io](https://img.shields.io/badge/Sentry-Sentry.io-%233A3A3C)



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

## Screenshots

Expense Page:
<img src="https://github.com/satyamlal/YourMoney/assets/26645754/7254239b-03f7-451b-a946-cf5a6a532913" width="250">

Settings Page:
![IMG_20230509_153939](https://github.com/satyamlal/YourMoney/assets/26645754/dd8fa487-f488-471f-aab6-a1c6a6667ab3=250x250)

Categories Page: With some added categories
![IMG_20230509_151925](https://github.com/satyamlal/YourMoney/assets/26645754/68265d59-e0f8-4842-8b6c-62ff64b8f64f=250x250)

Categories Page: Custom category can be added
![IMG_20230509_151833](https://github.com/satyamlal/YourMoney/assets/26645754/60d9d117-df94-4ba0-a155-ed2e42320edd=250x250)

Add Page: with added custom categories
![IMG_20230509_151906](https://github.com/satyamlal/YourMoney/assets/26645754/970ae94b-6fd5-4ba4-ad23-a60341ab2a7a=250x250)

Add Page: Custom Date Feature
![IMG_20230509_151851](https://github.com/satyamlal/YourMoney/assets/26645754/0de6acab-d4df-4fdd-b5bc-ffab4f421c05=250x250)

Reports Page: With Extra
![IMG_20230509_154428](https://github.com/satyamlal/YourMoney/assets/26645754/cb316b90-fed1-4c26-834f-84f8e4c37a9b=250x250)


## How to Revert Back to the previous version?

Jumping back to the previous version of my code after coding and fixing bugs for the last 2 days, because I am getting a lot of unexpected error.
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

