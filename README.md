# slacker

Loading multiple data sources via RxJava
Inspirations from @danlew42: http://blog.danlew.net/2015/06/22/loading-data-from-multiple-sources-with-rxjava/

Todo:
- Handling Configuration Changes With Request Observables: If a network request is made at `UsersListActivity#onCreate` and does not get a response by `onDestroy`, then a subscription is `unsubscribe`d. That case a response is not saved even if a network request is successful. One way to approach this is having POJO in Application level and have that instance responsible for making/responding network requests, and `Activity` will be binded `onCreate` and unbinded `onDestroy` to interact with network instances.
