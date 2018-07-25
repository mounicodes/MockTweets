# MockTweets
Developed an application that mocks the Twitter App. It should contain all the views/functionalities of Twitter.
## Implementation Plan:
Phase # | Description | Status
--------|-------------|-------
1|Login with Twitter, Home Timeline, Navigation |Done
2|Include Trends, Compose Tweet | Done
3|Home Timeline make HashTags, Mentions, Links Clickable| Done
4|Include Auto-Play Videos/Gifs in Timeline | Work In Progress
5|Navigation Menu Implementation | To be Implemented
## API:
Twitter API https://developer.twitter.com/en/docs/api-reference-index
## 3rd Party Libraries:
Glide|Retrofit
## Implementation:
* Used TwitterLoginButton for Authentication with Twitter
* Used Navigation View|View Pager|Tab Layout|Fragments|TwitterApiClient
* Extracted the necessary drawables from the Twitter APK
## Note: 
Make sure to generate the Access key & Consumer key and place it in the Constants class for this app to work.
## Demo:
------------
![](Tweeter.gif)
