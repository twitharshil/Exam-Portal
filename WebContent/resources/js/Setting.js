var check = function() {
  if (document.getElementById('NewPassword').value ==
    document.getElementById('ConfirmPassword').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Matching New And Confirm Password';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Not Matching Password';
  }
}