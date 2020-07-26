package com.beetlestance.sample

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.beetlestance.beetleextensions.navigation_extensions.NavigateOnceDeeplinkRequest
import com.beetlestance.sample.event.Event
import com.beetlestance.sample.ui.dashboard.DashboardFragment
import com.beetlestance.sample.ui.notifications.NotificationsFragment
import javax.inject.Inject

interface TopLevelNavigatorViewModelDelegate {
    /**
     * @see DashboardFragment.onViewCreated
     *  should only be observe in main fragment (i.e dashboardFragment)
     *  */
    val navigatorDeeplink: MutableLiveData<Event<NavigateOnceDeeplinkRequest>>

    /**
     * @see NotificationsFragment.onViewCreated
     */
    val clearBackStack: MutableLiveData<Event<Boolean>>

    /**
     * used to set deeplink in case of app start, if user is logged in it will navigated to destination
     * onCreate of dashboard fragment
     * @see DashboardFragment.setupBottomNavigationBar
     * @see MainActivity.handleDeeplink
     */
    var handleDeeplinkIfAny: NavigateOnceDeeplinkRequest?
}

class NavigatorViewModelDelegate @Inject constructor() : TopLevelNavigatorViewModelDelegate {
    override val navigatorDeeplink: MutableLiveData<Event<NavigateOnceDeeplinkRequest>> =
        MutableLiveData()

    override var handleDeeplinkIfAny: NavigateOnceDeeplinkRequest? = null

    override val clearBackStack: MutableLiveData<Event<Boolean>> = MutableLiveData(Event(false))

}
