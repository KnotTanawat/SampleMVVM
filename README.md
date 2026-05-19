# SampleMVVM — Android Kotlin MVVM Reference

A reference Android project demonstrating modern MVVM architecture with Kotlin, Coroutines, Dagger 2, Retrofit, and Room.

## Architecture

```
View (Activity/Adapter)
    └── ViewModel (AndroidViewModel + viewModelScope)
            └── Repository (cache-first strategy)
                    ├── RemoteDataSource  (Retrofit + suspend)
                    └── LocalDataSource   (Room + suspend)
```

## Tech Stack

| Layer | Library |
|---|---|
| Language | Kotlin 1.9 |
| Async | Kotlin Coroutines |
| DI | Dagger 2 |
| Network | Retrofit 2 + OkHttp |
| Local DB | Room |
| Reactive UI | LiveData + Data Binding |

## Key Patterns

### sealed class Result
Replaces the old callback-based `ResponseHandler`. All data operations return `Result<T>`:
```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val code: Int, val message: String) : Result<Nothing>()
}
```

### Cache-first Repository
```kotlin
suspend fun getNews(): Result<ResponseModel> {
    val cached = local.loadFromCache()
    if (cached is Result.Success) return cached      // serve from Room
    return when (val result = remote.fetchRemote()) {
        is Result.Success -> { local.saveToCache(result.data); result }
        is Result.Error   -> result
    }
}
```

### ViewModel with viewModelScope
```kotlin
fun loadNews() {
    viewModelScope.launch {          // auto-cancelled on ViewModel cleared
        when (val result = newsRepository.getNews()) {
            is Result.Success -> newsList.value = result.data.articles
            is Result.Error   -> onToast.postValue("Error: ${result.message}")
        }
    }
}
```

### BaseActivity (Dagger injection fix)
The original code called `inject(mActivityComponent)` before the component was built.
Fixed by building the component first, then passing it:
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    inject(getActivityComponent())   // build first, then inject
}
```

## Getting Started

1. Clone the repo
2. Open in Android Studio Hedgehog (2023.1.1) or newer
3. Sync Gradle
4. Run on a device or emulator (API 23+)

## API

Uses the public [Jikan REST API](https://jikan.moe/) (`manga/1/news`) — no API key required.