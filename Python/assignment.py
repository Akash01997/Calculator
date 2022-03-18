# -*- coding: utf-8 -*-
"""
Created on Thu Nov 11 18:17:19 2021

@author: adshi
"""

# ask the user to input their name. Check the length of the name. If it is
# greater than 5 characters long, write a message telling them how many characters
# otherwise write a message saying the length of their name is a secret

name = input('Please enter your Name>>>')

name_len = len(name)

if name_len > 5:
    print('Your name contain', name_len, 'characters')
elif name_len < 5:
    print('Length of you name is secret')
elif name_len == 5:
    print('Your name contains 5 character')