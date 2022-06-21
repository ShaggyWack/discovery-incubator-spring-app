package com.example.movie_demo_java.generated_implementation.services;

import com.gen.movie_demo_java.comicstock.IssuesApi;
import com.gen.movie_demo_java.comicstock.models.IssueDto;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class IssuesService implements IssuesApi {
    private String BASE_URL = "http://frontendshowcase.azurewebsites.net";

    // Required get methods.
    @Override
    public Call<List<IssueDto>> issuesGet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IssuesApi serviceInterface = retrofit.create(IssuesApi.class);

        Call<List<IssueDto>> retrofitCall = serviceInterface.issuesGet();

        return retrofitCall;
    }

    @Override
    public Call<IssueDto> issuesGet_0(Integer id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IssuesApi serviceInterface = retrofit.create(IssuesApi.class);

        Call<IssueDto> retrofitCall = serviceInterface.issuesGet_0(id);

        return retrofitCall;
    }

    // Not needed for current project
    @Override
    public Call<Void> issuesAdd(Integer issueId, String stockId, Integer conditionId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesAdd_0(Integer issueId, String supplierId, Integer conditionId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesDelete(Integer id) {
        return null;
    }

    @Override
    public Call<Void> issuesDelete_0(String issueId, String stockId, Integer id) {
        return null;
    }

    @Override
    public Call<Void> issuesDelete_1(String supplierId, String issueId, Integer id) {
        return null;
    }


    @Override
    public Call<List<IssueDto>> issuesGetForSupplier(String issueId, String stockId, Integer supplierId) {
        return null;
    }

    @Override
    public Call<List<IssueDto>> issuesGetForSupplier_0(Integer supplierId, String issueId) {
        return null;
    }

    @Override
    public Call<List<IssueDto>> issuesGet_1(String issueId, String stockId) {
        return null;
    }

    @Override
    public Call<List<IssueDto>> issuesGet_2(String supplierId, String issueId) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPost(IssueDto issue) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPost_0(IssueDto issue, String issueId, String stockId) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPost_1(IssueDto issue, String supplierId, String issueId) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPut(IssueDto issue) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPut_0(IssueDto issue, String issueId, String stockId) {
        return null;
    }

    @Override
    public Call<IssueDto> issuesPut_1(IssueDto issue, String supplierId, String issueId) {
        return null;
    }

    @Override
    public Call<Void> issuesRemove(Integer issueId, Integer stockId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesRemove_0(Integer issueId, Integer stockId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesRemove_1(Integer issueId, String supplierId, Integer stockId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesReturn(Integer issueId, String stockId, Integer conditionId, Integer quantity) {
        return null;
    }

    @Override
    public Call<Void> issuesReturn_0(Integer issueId, String supplierId, Integer conditionId, Integer quantity) {
        return null;
    }
}
