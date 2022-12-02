package com.unitapplications.retro.Api_Package;

import com.unitapplications.retro.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiSet {
    @GET("get_posts.php")
    Call<ResponseModel> getMemes();

    @FormUrlEncoded
    @POST("add_in_app.php")
    Call<ResponseModel> setMemes(
    @Field("header") String header
    );
//codes of api

    //get_posts.php
    /*

    <?php
/       //get_posts.php

        $servername = "localhost";
        $username = "root";
        $password = "";
        $database = "meme_db";

        $conn = new mysqli($servername,$username,$password,$database);

        if($conn->connect_error){
            die("connection failed bro : ".$conn->connect_error);
        }

        $query = "SELECT * FROM table_post";

        $result = $conn->query($query);
        $row = $result->fetch_all(MYSQLI_ASSOC);

        if(empty($row)){
            $response = array("status"=>"0","message"=>"Its empty","data"=>$row);
        }
        else{
            $response = array("status"=>"1","message"=>"Its Available","data"=>$row);
        }
        echo json_encode($response)
    ?>

    */

    //add_in_app.php
/*
    <?php //add_in_app.php
        $servername = "localhost";
        $username = "root";
        $password = "";
        $database = "meme_db";

        $conn = new mysqli($servername,$username,$password,$database);

        if($conn->connect_error){
            die("connection failed bro : ".$conn->connect_error);
        }
        $name=$_POST['header'];
        $qry="INSERT INTO `table_post` (`id`, `header`, `image`, `date`, `time`)
        VALUES (NULL, '$name', 'Updated_Imran_ logo.jpg', '2022-11-24', '09:56:30')";
        $result = $conn->query($qry);

        if($result==1){
            $response = array("status"=>"1","message"=>"Successfully Inserted");
        }else{
            $response = array("status"=>"0","message"=>"Failed to Insert");
        }
        echo json_encode($response)
?>
*/
}