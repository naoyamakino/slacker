package com.naoya.slacker.daggermodules;

import com.naoya.slacker.data.remote.RemoteDataFetcher;
import com.naoya.slacker.data.remote.SlackRestAdapter;
import com.naoya.slacker.ui.UsersListActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Naoya on 15-07-30.
 */
@Module(library = true, injects = {UsersListActivity.class})
public class DataModules {
    private static final String SLACK_API_ENDPOINT = "https://slack.com/api";
    private static final String SLACK_API_TOKEN = "xoxp-5048173296-5048346304-5180362684-7b3865";

    @Singleton
    @Provides
    SlackRestAdapter provideSlackRestAdapter() {
        RestAdapter build = new RestAdapter.Builder()
                .setEndpoint(SLACK_API_ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addQueryParam("token", SLACK_API_TOKEN);
                    }
                })
                .build();
        return build.create(SlackRestAdapter.class);
    }

    @Singleton
    @Provides
    RemoteDataFetcher provideRemoteDataFetcher(SlackRestAdapter slackRestAdapter) {
        return new RemoteDataFetcher(slackRestAdapter);
    }

}
