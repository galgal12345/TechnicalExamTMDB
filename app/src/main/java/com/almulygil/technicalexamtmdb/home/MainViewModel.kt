package com.almulygil.technicalexamtmdb.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almulygil.technicalexamtmdb.base.utils.Constants
import com.almulygil.technicalexamtmdb.common.data.local.store.UserPreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionManager: UserPreferenceManager
) : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    fun configureUserName() {
        viewModelScope.launch {
            sessionManager.getUserUserName()
                .collectLatest {
                    if(!it.isNullOrEmpty()) {
                        _userName.postValue(it)
                    }else{
                        _userName.postValue(Constants.DEFAULT_NAME)
                    }
                }
        }
    }

    fun setUserName(username: String) {
        viewModelScope.launch {
            sessionManager.setUserName(username)
        }
    }

}