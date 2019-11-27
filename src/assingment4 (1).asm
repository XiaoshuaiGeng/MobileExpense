; Calculating a Factorial                   (Fact.asm)

; This program uses recursion to calculate the
; factorial of an integer.

include Irvine32.inc
.data
	msg1 byte " ",0
	msg2 byte "Enter size of fib value: ",0
	msg3 byte "Fibonacci sequence with N = ",0
	msg4 byte "is: ",0
.code
main PROC
    mov ecx,0
	mov edx,OFFSET msg2
	call WriteString
	call ReadInt
	mov ecx,eax
	inc ecx

	mov edx,OFFSET msg3
	call WriteString
	call WriteDec
	mov edx,OFFSET msg4
	call WriteString

    push eax             ; calculate the nth fib
    call fib            ; calculate fib (eax)
    add esp, 4          ; clean up the stack
	
	mov eax,0
	mov ebx,1
	

	L1:
		jecxz quit
		add ebx,eax
		call WriteDec
		mov edx, OFFSET msg1
		call WriteString
		xchg eax,ebx
		loop L1
    call Crlf
	quit:
    exit
main ENDP

fib PROC C
    
    push ebp
    mov  ebp,esp
    sub  esp, 4         ; space for a local dword [ebp-4]
    mov  eax,[ebp+8]    ; get n

    ; if ((n == 1) || (n == 2)) return 1;
    cmp  eax,2          ; n == 2?
    je   exception2
    cmp  eax,1          ; n == 1?
    je   exception2

    ;else return fib(n-1) + fib(n-2);
    dec eax
    push eax            ; Fib(n-1)
    call fib
    mov [ebp-4], eax    ; store first result

    dec dword ptr [esp] ; (n-1) on the stack -> (n-2)
    call fib
    add esp, 4          ; clean up stack

    add eax, [ebp-4]    ; add result and stored first result

    jmp Quit

exception2:
    mov eax, 1          ; start values: 1, 1
    ; dec eax           ; start values: 0, 1
Quit:
    mov esp, ebp        ; restore esp
    pop ebp             ; restore ebp

    ret                 ; return EAX, stack not cleaned up
fib ENDP

END main