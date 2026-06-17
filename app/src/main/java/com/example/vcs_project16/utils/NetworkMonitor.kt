package com.example.vcs_project16.utils

import android.content.Context
import android.net.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkMonitor @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    private val manager =
        context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
    val isOnline: Flow<Boolean> = callbackFlow @androidx.annotation.RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE) {
        val callback =
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(
                    network: Network
                ) {
                    trySend(true)
                }
                override fun onLost(
                    network: Network
                ) {
                    trySend(false)
                }
            }
        manager.registerDefaultNetworkCallback(
            callback
        )
        awaitClose {
            manager.unregisterNetworkCallback(
                callback
            )
        }
    }
}