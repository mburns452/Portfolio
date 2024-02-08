using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
/// <summary>
/// Author: Mason Burns
/// Date: 11/29/2022
/// 
/// Player script that handles the player's movement and animation.
/// </summary>
public class Player : MonoBehaviour
{
    //Getting access to the rigidbody component
    public Rigidbody2D rb;

    //Creating variables for movespeed, jumpheight, and direction
    public float moveSpeed = 1f;
    public float jumpHeight = 10f;
    private float direction = 0f;

    //Variables for limiting the jumping to once instead of infinite
    public Transform groundCheck;
    public float groundCheckRadius;
    public LayerMask groundLayer;
    private bool isTouchingGround;

    private Animator playerAnimation;

    
    void Start()
    {
        //grabing the players animator
        playerAnimation = GetComponent<Animator>();
    }

    
    void Update()
    {
        //checks to see if the player is on the ground
        //used to limit jumping
        isTouchingGround = Physics2D.OverlapCircle(groundCheck.position,groundCheckRadius, groundLayer);
        direction = Input.GetAxis("Horizontal");
        //Code to move the player left and right and also turns the player to face the correct direction
        if (direction > 0f)
        {
            rb.velocity = new Vector2(direction * moveSpeed, rb.velocity.y);
            transform.localScale = new Vector2(1f,1f);
        }
        else if (direction < 0f)
        {
            rb.velocity = new Vector2(direction * moveSpeed, rb.velocity.y);
            transform.localScale = new Vector2(-1f, 1f);
        }
        else
        {
            rb.velocity = new Vector2(0, rb.velocity.y);
        }
        //code to allow the player to jump
        if (Input.GetButtonDown("Jump") && isTouchingGround)
        {
            rb.velocity = new Vector2(rb.velocity.x, jumpHeight);
        }

        //passing the player's velocity to the animator to play the walking animation
        playerAnimation.SetFloat("Speed", Mathf.Abs(rb.velocity.x));
    }
}
