from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^main$', views.index),
    url(r'^register$', views.register),
    url(r'^login$', views.login),
    url(r'^logout$', views.logout),
    url(r'^travels$', views.success),
    url(r'^add$', views.add_plan),
    url(r'^create$', views.create),
    url(r'^show/(?P<travel_id>\d+)$', views.show),
    url(r'^join/(?P<travel_id>\d+)$', views.join),
]