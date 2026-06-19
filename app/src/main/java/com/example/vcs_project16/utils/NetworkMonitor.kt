package com.example.vcs_project16.utils

import android.content.Context
import android.net.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
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
    private fun getCurrentNetworkStatus(): Boolean {
        val network = manager.activeNetwork ?: return false
        val capabilities = manager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(
            NetworkCapabilities.NET_CAPABILITY_VALIDATED
        )
    }
    val isOnline: Flow<Boolean> = callbackFlow {
        trySend(
            getCurrentNetworkStatus()
        )
        val callback =
            object : ConnectivityManager.NetworkCallback() {
                override fun onCapabilitiesChanged(
                    network: Network,
                    capabilities: NetworkCapabilities
                ) {
                    trySend(
                        capabilities.hasCapability(
                            NetworkCapabilities.NET_CAPABILITY_VALIDATED
                        )
                    )
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