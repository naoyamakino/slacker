package com.naoya.slacker.daggermodules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.naoya.slacker.data.remote.RemoteDataSource;
import com.naoya.slacker.data.remote.SlackRestAdapter;
import com.naoya.slacker.ui.UsersListActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by Naoya on 15-07-30.
 */
@Module(library = true, injects = {UsersListActivity.class})
public class DataModules {
    private static final String SLACK_API_ENDPOINT = "https://slack.com/api";
    private static final String SLACK_API_TOKEN = "xoxp-5048173296-5048346304-5180362684-7b3865";

    @Singleton
    @Provides
    SlackRestAdapter provideSlackRestAdapter(Converter converter) {
        RestAdapter build = new RestAdapter.Builder()
                .setEndpoint(SLACK_API_ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(converter)
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
    Converter provideGsonConverter() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return new GsonConverter(gson);
    }

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource(SlackRestAdapter slackRestAdapter) {
        return new RemoteDataSource(slackRestAdapter);
    }

}
