<script setup lang="ts">
import LoginForm from "@/components/LoginForm.vue";

const handleFormSubmission = (contactMessage: string) => {
  console.log(contactMessage);
};

</script>

<template>
  <div >
    <div>

      <div>
        <h1 class="h1-title">Log in</h1>
        <p>
          Input log-in details.
        </p>
      </div>

      <div class="form-container">
        <LoginForm @message-submitted="handleFormSubmission" />
      </div>

    </div>
  </div>
</template>

<style scoped>


.form-container {
  display: flex;
  flex-direction: column;
  align-items: center; /* Center children horizontally in the flex container */
  width: 100%; /* Use the full width of the parent container */
  max-width: 600px; /* Maximum width of the content, adjust as needed */
  margin: 0 auto; /* Center the .contact div inside its container */
}

.h1-title {
  text-align: center;
  padding-bottom: 12px;
  font-weight: bolder;
}

p {
  font-weight: bold;
}

</style>

