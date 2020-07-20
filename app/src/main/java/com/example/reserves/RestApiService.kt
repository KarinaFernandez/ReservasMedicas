package com.example.reserves

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestApiService {
    private val retrofit = ServiceBuilder.buildService(EndpointsInterface::class.java)

    fun loginUser(userData: UserData, onResult: (UserData?) -> Unit) {
        retrofit.loginUser(userData).enqueue(
            object : Callback<UserData> {
                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun createUser(userData: UserData, onResult: (UserData?) -> Unit) {
        retrofit.createUser(userData).enqueue(
            object : Callback<UserData> {
                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun getDoctors(onResult: (ArrayList<DoctorData>?) -> Unit) {
        retrofit.getDoctors().enqueue(
            object : Callback<ArrayList<DoctorData>> {
                override fun onResponse(
                    call: Call<ArrayList<DoctorData>>,
                    response: Response<ArrayList<DoctorData>>
                ) {
                    val doctors = response.body()
                    onResult(doctors)
                }

                override fun onFailure(call: Call<ArrayList<DoctorData>>, t: Throwable) {
                    onResult(null)
                }
            })
    }

    fun createSchedule(scheduleData: ScheduleData, onResult: (ScheduleData?) -> Unit) {
        retrofit.createSchedule(scheduleData).enqueue(
            object : Callback<ScheduleData> {
                override fun onFailure(call: Call<ScheduleData>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<ScheduleData>,
                    response: Response<ScheduleData>
                ) {
                    val schedule = response.body()
                    onResult(schedule)
                }
            }
        )
    }
}