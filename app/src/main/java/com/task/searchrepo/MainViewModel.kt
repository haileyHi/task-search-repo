package com.task.searchrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.searchrepo.model.Repo
import com.task.searchrepo.repository.RepoService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.properties.Delegates

class MainViewModel : ViewModel() {
    enum class Action {
        KEYWORD, PAGE, SORT, ORDERBY
    }
    // 검색 결과
    private val _itemLiveData = MutableLiveData<MutableList<Repo>>() // 뮤터블 - 수정 가능, LiveData - 수정 불가
    val itemLiveData: LiveData<MutableList<Repo>>
        get() = _itemLiveData
    private val _totalItemCountLiveData = MutableLiveData<Long>()
    val totalItemCountLiveData: LiveData<Long>
        get() = _totalItemCountLiveData
    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    private var service: RepoService

    private var page by Delegates.notNull<Int>()

    private val _keyword = MutableLiveData<String>() // 뷰모델 내부에서 설정하는 자료형
    val keyword: LiveData<String>
        get() = _keyword
    private val _hasMore = MutableLiveData<Boolean>() // 다음 페이지로 넘어갈 수 있는지 확인용
    val hasMore: LiveData<Boolean>
        get() = _hasMore

    private val _sort = MutableLiveData<String>()
    val sort: LiveData<String>
        get() = _sort
    private val _orderby = MutableLiveData<String>()
    val orderby: LiveData<String>
        get() = _orderby

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(RepoService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(RepoService::class.java)

        _loadingLiveData.value = false
        _sort.value = "bestmatch"
    }

    // LiveData로 데이터 관찰
    fun fetchSearchInfo() {
        // 로딩 시작
        _loadingLiveData.value = true

        viewModelScope.launch {
            if (page < 35) {
                val searchInfo = service.fetchRepo(
                    keyword = _keyword.value!!,
                    page = page,
                    sort = _sort.value,
                    order = _orderby.value
                )
                if (searchInfo.items != null) {
                    if (page >= 2) {
                        itemLiveData.value?.addAll(searchInfo.items as Collection<Repo>)
                        _hasMore.value = totalItemCountLiveData.value!! > (page * 30)
                        // 1000개 넘으면 불러올 수 없음.
                    } else {
                        _itemLiveData.value = (searchInfo.items as MutableList<Repo>?)!!
                        _totalItemCountLiveData.value = searchInfo.totalCount
                    }
                }
            } else {
                _hasMore.value = false
            }
            // 로딩 끝
            _loadingLiveData.value = false
        }
    }

    fun updateValue(actionType: Action, input: String?, pNum: Int) {
        when (actionType) {
            Action.KEYWORD -> {
                _keyword.value = input!!
                page = pNum
            }
            Action.PAGE -> {
                page = pNum
            }
            Action.SORT -> {
                _sort.value = input!!
                page = pNum
            }
            Action.ORDERBY -> {
                _orderby.value = input!!
                page = pNum
            }
        }

    }
}