package com.it.shka.feature_auth.domain

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OpenUrlInBrowserUseCase(
    private val context: Context,
    private val packageManager: PackageManager
) {
    suspend fun execute(url: String): Result<Unit> = withContext(Dispatchers.Main) {
        runCatching {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
            }
            when {
                intent.resolveActivity(packageManager) != null -> {
                    intent.setPackage(null)
                    context.startActivity(intent)
                }
                else -> {
                    throw ActivityNotFoundException("No browser application found")
                }
            }
        }
    }
}