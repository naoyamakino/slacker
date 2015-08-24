# slacker

Loading multiple data sources via RxJava

Inspirations from @danlew42: http://blog.danlew.net/2015/06/22/loading-data-from-multiple-sources-with-rxjava/

Todo:
- Handling Configuration Changes With Request Observables: If a network request is made at `UsersListActivity#onCreate` and does not get a response by `onDestroy`, then a subscription is `unsubscribe`d. That case a response is not saved even if a network request is successful. One way to approach this is having POJO in an Application level and have that instance be responsible for making/responding network requests, and `Activity` will be binded `onCreate` and unbinded `onDestroy` to interact with network instances.

- Memory cache in `UsersListActivity` needs to handle a case of being stale; i.e when a new content is available on the server side, and we have a memory cache available. This case the app displays out-dated information as it skips a network request in favour of memory cache.
It would need to add a way to be informed whether a new content is available on server side. GCM would be an ideal solution as it removes an need of polling. Otherwise, if API supports a parameter to fetch a content updated since a given datetime, we can see if a new content is available by periodic checks.
Or we can clean a memory cache when a certain duration has passed, so that it will hit a network request after X time.

- In order to replace an implementation detail of how data is stored on disk, I would have an interface called `DiskDataSource` with methods, `getUsers` and `saveUserList`, instead of having an implementation class with two interfaces implemented, namely `DataFetcher` and `DataRetainer`.
That way, the only thing you would need to do to switch an implementation is to implement `DiskDataSource`. Currently `DataFetcher` and `DataRetainer` interfaces offer a common interface for interacting with different type of data, i.e network, memory and disk, but it is not well suited to offer a different implementation for a same type of storage.

- As noted earlier, profile images are cached only when UserDetailActivity is visited; that is if user visits an profile page when offline yet has not visisted that page while online, then the profile image for that user won't be displayed. It would need to tigger a service which will make HTTP requests to download all of users' profile images, storing image responses. Volley would be a suitable HTTP client for this as it handles multiple http operations nicely.

- UserDetailActivity does not have a way to update a downloaded image for a profile when there is a new profile image available on the server. It suffers a similar problem I described how `UsersListActivity` needs to handle a staled cache. Similar approach (either using GCM to be notified or polling) can be used to address the issue.

