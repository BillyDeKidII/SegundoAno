^j::
   MsgBox Wow!
   MsgBox this is
   Run, Notepad.exe
   winactivate, Untitled - Notepad
   WinWaitActive, Untitled - Notepad
   send, 7 lines{!}{enter}
   sendinput, inside the ctrl{+}j hotkey
Return
