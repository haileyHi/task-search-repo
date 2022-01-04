package com.task.searchrepo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.searchrepo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: RepoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    private lateinit var keyword: String
    private var page: Int = 1
    private var isMore: Boolean = true

    // sort 다이얼로그
    private lateinit var selectionDialog: AlertDialog
    private val mSortSelections =
        arrayOf<String>("stars", "forks", "updated", "bestmatch")
    private var prevChoice: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // searchView 리스너 설정
        searchView = binding.svKeyword
        initQueryTextListener()

        // recyclerview 어댑터 연결, 리스너 설정
        recyclerView = binding.rvSearchResult
        adapter = RepoAdapter()
        recyclerView.adapter = adapter
        initScrollListener()

        // viewModel 필드 observe 일괄 적용하기
        viewModel.apply {
            itemLiveData.observe(this@MainActivity, { it ->
                adapter.updateItems(it)
            })
            totalItemCountLiveData.observe(this@MainActivity, { num ->
                binding.tvResultCount.text = "검색 결과 : $num 개"
            })
            loadingLiveData.observe(this@MainActivity, { loading ->
                binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
            })
            hasMore.observe(this@MainActivity, {
                isMore = it
            })
            sort.observe(this@MainActivity, {
                binding.tvSortStd.text = it
                if(it == "bestmatch"){
                    binding.ivOrderby.isSelected = true
                    binding.ivOrderby.isEnabled = false
                }else {
                    binding.ivOrderby.isEnabled = true
                }
            })
        }

        // 선택 다이얼로그
        selectionDialog = AlertDialog.Builder(this)
            .setSingleChoiceItems(mSortSelections, 3
            ) { dialog, which ->
                if (prevChoice != which) {
                    page = 1
                    if (which == 3) {
                        binding.ivOrderby.isSelected = true
                        viewModel.updateValue(3,"desc", page)
                    }
                    viewModel.updateValue(2, mSortSelections[which], getPage())
                    loadData(0)
                    prevChoice = which
                }
                binding.ivOrderby.isEnabled = which != 3

                selectionDialog.dismiss()
            }
            .create()

        binding.tvSortStd.setOnClickListener {
            selectionDialog.show()
        }
        binding.tvSortStd.visibility = View.GONE

        binding.ivOrderby.setOnClickListener {
            binding.ivOrderby.isSelected = !binding.ivOrderby.isSelected
            val order = if (binding.ivOrderby.isSelected) "desc" else "asc"
            page = 1
            viewModel.updateValue(3,order, getPage())
            loadData(0)
        }
        binding.ivOrderby.visibility = View.GONE
    }

    fun loadData(loadingType: Int) {
        when (loadingType) {
            0 -> viewModel.fetchSearchInfo() // 새로 가져오기
            1 -> {
                viewModel.updateValue(actionType = 1, input = null, pNum = getPage()) // 추가하기
                viewModel.fetchSearchInfo()
            }
        }
    }

    fun initQueryTextListener() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    // 키워드 갱신
                    keyword = query
                    // 페이지 수 갱신
                    page = 1

                    viewModel.updateValue(0, keyword,getPage())
                    loadData(loadingType = 0)
                    binding.tvSortStd.visibility = View.VISIBLE
                    binding.ivOrderby.visibility = View.VISIBLE
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    fun initScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager

                if (hasMore()) {
                    val lastSeenItem = (layoutManager as LinearLayoutManager)
                        .findLastCompletelyVisibleItemPosition()
                    // 현재 로드되어 있는 데이터의 마지막즈음 접근하면 다음 페이지를 추가로 불러오자
                    if (layoutManager.itemCount <= lastSeenItem + 2) {
                        loadData(1)
                        checkNext(false)
                    }
                } else if (layoutManager != null && layoutManager.itemCount >= 1000) {
                    Toast.makeText(this@MainActivity, "더 이상 데이터를 가져올 수 없습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    fun getPage(): Int = page++

    fun hasMore(): Boolean {
        return isMore
    }

    fun checkNext(flag: Boolean) {
        isMore = flag
    }
}