# -*- coding: utf-8 -*-
"""
Created on Wed Nov 10 20:31:36 2021

@author: adshi
"""

#Write code that asks the user to input a number between 1 and 5 inclusive.
# The code will take the integer value and print out the string value. So for
# example if the user inputs 2 the code will print two. Reject any input that
# is not a number in that range

user_input = int(input('Please enter a number between 1 and 5>>>'))

user_input = user_input.lower()
if user_input == 1:
    print('One')
if user_input == 2:
    print('Two')
if user_input == 3:
    print('Three')
if user_input == 4:
    print('Four')
if user_input == 5:
    print('Five')
if user_input > 5:
    print('Out of Range')
