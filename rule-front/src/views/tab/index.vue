<template>
  <div class="tab-container">
    <iframe id="inlineFrameExample"
            title="Inline Frame Example"
            width="300"
            height="200"
            src="http://localhost:8080/vbi/authDashboard.html#/top/view/7521/status=second">
    </iframe>
  </div>
</template>

<script>
import tabPane from './components/TabPane'

export default {
  name: 'Tab',
  components: { tabPane },
  data() {
    return {
      tabMapOptions: [
        { label: 'China', key: 'CN' },
        { label: 'USA', key: 'US' },
        { label: 'Japan', key: 'JP' },
        { label: 'Eurozone', key: 'EU' }
      ],
      activeName: 'CN',
      createdTimes: 0
    }
  },
  watch: {
    activeName(val) {
      this.$router.push(`${this.$route.path}?tab=${val}`)
    }
  },
  created() {
    // init the default selected tab
    const tab = this.$route.query.tab
    if (tab) {
      this.activeName = tab
    }
  },
  methods: {
    showCreatedTimes() {
      this.createdTimes = this.createdTimes + 1
    }
  }
}
</script>

<style scoped>
  .tab-container {
    margin: 30px;
  }
</style>
