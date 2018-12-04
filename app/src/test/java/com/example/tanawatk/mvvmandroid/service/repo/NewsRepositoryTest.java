package com.example.tanawatk.mvvmandroid.service.repo;

import com.example.tanawatk.mvvmandroid.service.repo.local.NewsLocalDataSource;
import com.example.tanawatk.mvvmandroid.service.repo.remote.NewsRemoteDataSource;

import org.junit.Before;

import static org.junit.Assert.*;

public class NewsRepositoryTest {

    NewsRepository repo;

    @Before
    public void setUp() throws Exception {
        NewsLocalDataSource local = new NewsLocalDataSource();

    }
}